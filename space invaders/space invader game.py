import random
import math
import pygame
from pygame import mixer

pygame.init()

screen = pygame.display.set_mode((800, 600))

background = pygame.image.load('background.png')

mixer.music.load("background.wav")
mixer.music.play(-1)

pygame.display.set_caption("Space Invader")
icon = pygame.image.load("ufo.png")
pygame.display.set_icon(icon)

score_value = 0
font = pygame.font.Font("freesansbold.ttf", 32)

testX = 10
testY = 10

playerImg = pygame.image.load('player.png')
playerX = 370
playerY = 480
playerX_change = 0

enemyImg = []
enemyX = []
enemyY = []
enemyX_change = []
enemyY_change = []
num_of_enemies = 6

for i in range(num_of_enemies):
    enemyImg.append(pygame.image.load("enemy.png"))
    enemyX.append(random.randint(0, 736))
    enemyY.append(random.randint(50, 150))
    enemyX_change.append(4)
    enemyY_change.append(40)

bulletImg = pygame.image.load("bullet.png")
bulletX = 0
bulletY = 480
bulletX_change = 0
bulletY_change = 10
bullet_state = "ready"

def player(x, y):
    screen.blit(playerImg, (x, y))

def enemy(x, y, i):
    screen.blit(enemyImg[i], (x, y))

def show_score(x, y):
    score = font.render("Score : " + str(score_value), True, (255, 255, 255))
    screen.blit(score, (x, y))

def fire_bullet(x, y):
    global bullet_state
    bullet_state = "fire"
    screen.blit(bulletImg, (x + 16, y + 10))

def isCollision(enemyX, enemyY, bulletX, bulletY):
    distance = math.sqrt(math.pow(enemyX - bulletX, 2) + (math.pow(enemyY - bulletY, 2)))
    return distance < 27

def set_background():
    screen.fill((0, 0, 0))
    screen.blit(background, (0, 0))

def move_bullet():
    global bulletY, bullet_state
    if bulletY <= 0:
        bulletY = 480
        bullet_state = "ready"
    
    if bullet_state == "fire":
        fire_bullet(bulletX, bulletY)
        bulletY -= bulletY_change

def game_input():
    global running, playerX_change, bulletX, playerX, bulletY, bullet_state
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                playerX_change = -5
            if event.key == pygame.K_RIGHT:
                playerX_change = 5
            if event.key == pygame.K_SPACE:
                if bullet_state == "ready":
                    bulletSound = mixer.Sound("laser.wav")
                    bulletSound.play()
                    bulletX = playerX
                    fire_bullet(bulletX, bulletY)
                    bullet_state = "fire"

        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                playerX_change = 0

def enemy_movement():
    global enemyX, enemyX_change, enemyY, enemyY_change
    for i in range(num_of_enemies):
        if enemyY[i] > -100:  # Only move visible enemies
            enemyX[i] += enemyX_change[i]
            if enemyX[i] <= 0:
                enemyX_change[i] = 4
                enemyY[i] += enemyY_change[i]
            elif enemyX[i] >= 736:
                enemyX_change[i] = -4
                enemyY[i] += enemyY_change[i]
            enemy(enemyX[i], enemyY[i], i)

def collision():
    global num_of_enemies, enemyX, enemyY, bulletX, bulletY, bullet_state, score_value
    for i in range(num_of_enemies):
        if enemyY[i] > -100:  # Only check collision for visible enemies
            if isCollision(enemyX[i], enemyY[i], bulletX, bulletY):
                explosionSound = mixer.Sound("explosion.wav")
                explosionSound.play()
                bulletY = 480
                bullet_state = "ready"
                score_value += 1
                enemyY[i] = -1000  # Move the enemy off-screen instead of respawning
                
def check_win():
    return all(y <= -100 for y in enemyY)

def show_win_message():
    win_font = pygame.font.Font("freesansbold.ttf", 64)
    win_text = win_font.render("YOU WIN!", True, (255, 255, 255))
    screen.blit(win_text, (200, 250))

running = True
game_won = False
while running:
    set_background()
    game_input()
    
    playerX += playerX_change
    playerX = max(0, min(playerX, 736))
    
    if not game_won:
        enemy_movement()
        collision()
        move_bullet()
        
        if check_win():
            game_won = True
    
    player(playerX, playerY)
    show_score(testX, testY)
    
    if game_won:
        show_win_message()
    
    pygame.display.update()