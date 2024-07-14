field = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]

current_player = 1

def draw_field(field):
    print(f"{field[0]} | {field[1]} | {field[2]}")
    print(f"{field[3]} | {field[4]} | {field[5]}")
    print(f"{field[6]} | {field[7]} | {field[8]}")
    print("\n")

def check_game_over(field):

    for i in range(0, 7, 3):
        if field[i] == field[i+1] == field[i+2] and field[i] != "1":
            draw_field(field)
            print(f"Player {current_player} wins!")
            exit()

    for i in range(0, 3):
        if field[i] == field[i+3] == field[i+6] and field[i] != "1":
            draw_field(field)
            print(f"Player {current_player} wins!")
            exit()

    if field[0] == field[4] == field[8] and field[0] != "1":
        draw_field(field)
        print(f"Player {current_player} wins!")
        exit()
    if field[2] == field[4] == field[6] and field[2] != "1":
        draw_field(field)
        print(f"Player {current_player} wins!")
        exit()

def get_input():
    while True:
        x = input("Enter the number where you want to place your mark (1-9): ")
        if x.isdigit() and 1 <= int(x) <= 9:
            return int(x) - 1
        else:
            print("Invalid input. Please enter a number between 1 and 9.")

def switch_player():
    global current_player
    if current_player == 1:
        current_player = 0
    else:
        current_player = 1

while True:
    x = get_input()
    field[x] = "x" if current_player == 1 else "o"
    switch_player()
    check_game_over(field)
    draw_field(field)
