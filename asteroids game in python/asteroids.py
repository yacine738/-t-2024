import pygame
import sys
import os
import random
import math

# Initialize Pygame
pygame.mixer.pre_init()
pygame.init()

# Game settings
WIDTH = 800
HEIGHT = 600
FPS = 60

# Colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
YELLOW = (255, 255, 0)

# Set up the game window
window = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Asteroids')
clock = pygame.time.Clock()

# Load images
def load_image(name):
    return pygame.image.load(os.path.join('images', name))

bg = load_image('bg.jpg')
debris = load_image('debris2_brown.png')
ship = load_image('ship.png')
ship_thrusted = load_image('ship_thrusted.png')
asteroid = load_image('asteroid.png')
shot = load_image('shot2.png')
explosion = load_image('explosion_blue.png')

# Load sounds
missile_sound = pygame.mixer.Sound(os.path.join('sounds', 'missile.ogg'))
thruster_sound = pygame.mixer.Sound(os.path.join('sounds', 'thrust.ogg'))
explosion_sound = pygame.mixer.Sound(os.path.join('sounds', 'explosion.ogg'))

# Background music
pygame.mixer.music.load(os.path.join('sounds', 'game.ogg'))
pygame.mixer.music.set_volume(0.3)
pygame.mixer.music.play(-1)

# Game variables
def init_game():
    global ship_x, ship_y, ship_angle, ship_is_rotating, ship_is_forward, ship_direction, ship_speed
    global asteroid_x, asteroid_y, asteroid_angle, no_asteroids
    global bullet_x, bullet_y, bullet_angle, no_bullet
    global score, game_over

    ship_x = WIDTH // 2 - 50
    ship_y = HEIGHT // 2 - 50
    ship_angle = 0
    ship_is_rotating = False
    ship_is_forward = False
    ship_direction = 0
    ship_speed = 0

    asteroid_x = []
    asteroid_y = []
    asteroid_angle = []
    no_asteroids = 5

    bullet_x = []
    bullet_y = []
    bullet_angle = []
    no_bullet = 0

    score = 0
    game_over = False

    # Initialize asteroids
    for i in range(no_asteroids):
        asteroid_x.append(random.randint(0, WIDTH))
        asteroid_y.append(random.randint(0, HEIGHT))
        asteroid_angle.append(random.randint(0, 365))

init_game()

def rot_center(image, angle):
    orig_rect = image.get_rect()
    rot_image = pygame.transform.rotate(image, angle)
    rot_rect = orig_rect.copy()
    rot_rect.center = rot_image.get_rect().center
    rot_image = rot_image.subsurface(rot_rect).copy()
    return rot_image

def draw(canvas):
    global time, ship_is_forward
    canvas.fill(BLACK)
    canvas.blit(bg, (0, 0))
    canvas.blit(debris, (time * 0.3 % WIDTH, 0))
    canvas.blit(debris, (time * 0.3 % WIDTH - WIDTH, 0))
    
    for i in range(no_bullet):
        canvas.blit(shot, (bullet_x[i], bullet_y[i]))

    for i in range(no_asteroids):
        canvas.blit(rot_center(asteroid, time), (asteroid_x[i], asteroid_y[i]))

    if ship_is_forward and not game_over:
        canvas.blit(rot_center(ship_thrusted, ship_angle), (ship_x, ship_y))
    else:
        canvas.blit(rot_center(ship, ship_angle), (ship_x, ship_y))

    # Draw Score
    myfont1 = pygame.font.SysFont("Arial", 40)
    label1 = myfont1.render("Score: " + str(score), 1, YELLOW)
    canvas.blit(label1, (50, 20))

    if game_over:
        myfont2 = pygame.font.SysFont("Arial", 80)
        label2 = myfont2.render("GAME OVER", 1, WHITE)
        canvas.blit(label2, (WIDTH // 2 - 150, HEIGHT // 2 - 40))
        
        myfont3 = pygame.font.SysFont("Arial", 40)
        label3 = myfont3.render("Press R to Restart", 1, WHITE)
        canvas.blit(label3, (WIDTH // 2 - 100, HEIGHT // 2 + 40))

def handle_input():
    global ship_angle, ship_is_rotating, ship_direction
    global ship_x, ship_y, ship_speed, ship_is_forward
    global bullet_x, bullet_y, bullet_angle, no_bullet
    global game_over

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            if not game_over:
                if event.key == pygame.K_LEFT:
                    ship_direction = 0
                    ship_is_rotating = True
                elif event.key == pygame.K_RIGHT:
                    ship_is_rotating = True
                    ship_direction = 1
                elif event.key == pygame.K_UP:
                    ship_is_forward = True
                    thruster_sound.play(-1)
                elif event.key == pygame.K_SPACE:
                    bullet_x.append(ship_x + 50)
                    bullet_y.append(ship_y + 50)
                    bullet_angle.append(ship_angle)
                    no_bullet += 1
                    missile_sound.play()
            if event.key == pygame.K_r and game_over:
                init_game()
        elif event.type == pygame.KEYUP:
            if event.key in (pygame.K_LEFT, pygame.K_RIGHT):
                ship_is_rotating = False
            elif event.key == pygame.K_UP:
                ship_is_forward = False
                thruster_sound.stop()

    if not game_over:
        if ship_is_rotating:
            if ship_direction == 0:
                ship_angle += 5
            else:
                ship_angle -= 5

        if ship_is_forward:
            ship_speed = min(ship_speed + 0.2, 10)
        else:
            ship_speed = max(ship_speed - 0.1, 0)

        ship_x = (ship_x + math.cos(math.radians(ship_angle)) * ship_speed) % WIDTH
        ship_y = (ship_y - math.sin(math.radians(ship_angle)) * ship_speed) % HEIGHT

def isCollision(x1, y1, x2, y2, dist):
    return math.hypot(x1 - x2, y1 - y2) < dist

def game_logic():
    global bullet_x, bullet_y, bullet_angle, no_bullet
    global asteroid_x, asteroid_y, asteroid_angle
    global score, game_over

    for i in range(no_bullet - 1, -1, -1):
        bullet_x[i] += math.cos(math.radians(bullet_angle[i])) * 10
        bullet_y[i] -= math.sin(math.radians(bullet_angle[i])) * 10
        if not (0 <= bullet_x[i] < WIDTH and 0 <= bullet_y[i] < HEIGHT):
            del bullet_x[i], bullet_y[i], bullet_angle[i]
            no_bullet -= 1

    for i in range(no_asteroids):
        asteroid_x[i] += math.cos(math.radians(asteroid_angle[i])) * 2
        asteroid_y[i] -= math.sin(math.radians(asteroid_angle[i])) * 2
        asteroid_x[i] %= WIDTH
        asteroid_y[i] %= HEIGHT

        if isCollision(ship_x, ship_y, asteroid_x[i], asteroid_y[i], 27):
            game_over = True
            explosion_sound.play()

        for j in range(no_bullet - 1, -1, -1):
            if isCollision(bullet_x[j], bullet_y[j], asteroid_x[i], asteroid_y[i], 20):
                asteroid_x[i] = random.randint(0, WIDTH)
                asteroid_y[i] = random.randint(0, HEIGHT)
                asteroid_angle[i] = random.randint(0, 365)
                del bullet_x[j], bullet_y[j], bullet_angle[j]
                no_bullet -= 1
                explosion_sound.play()
                score += 1

# Main game loop
time = 0
while True:
    time += 1
    draw(window)
    handle_input()
    if not game_over:
        game_logic()
    pygame.display.update()
    clock.tick(FPS)