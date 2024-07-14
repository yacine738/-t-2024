from tkinter import *
from tkinter import messagebox
from functools import partial


root = Tk()
root.title("Tic Tac Toe")


field = ["" for _ in range(9)]


current_player = 'X'


score_x = 0
score_o = 0


def draw_field():
    for i in range(9):
        button = buttons[i]
        button.config(text=field[i])


def check_game_over():
    global score_x, score_o
    # Check for winning combinations
    winning_combinations = [(0, 1, 2), (3, 4, 5), (6, 7, 8), (0, 3, 6), (1, 4, 7), (2, 5, 8), (0, 4, 8), (2, 4, 6)]
    for a, b, c in winning_combinations:
        if field[a] == field[b] == field[c] != "":
            if field[a] == 'X':
                score_x += 1
            else:
                score_o += 1
            messagebox.showinfo("Game Over", f"Player {field[a]} wins!")
            reset_game()
            return

    # Check for a tie
    if "" not in field:
        messagebox.showinfo("Game Over", "It's a tie!")
        reset_game()
        return

# Function to handle button clicks
def button_click(button_index):
    global current_player
    if field[button_index] == "":
        field[button_index] = current_player
        draw_field()
        check_game_over()
        if current_player == 'X':
            current_player = 'O'
        else:
            current_player = 'X'


def reset_game():
    global field, current_player
    field = ["" for _ in range(9)]
    current_player = 'X'
    draw_field()
    update_score_labels()

# Function to update the score labels
def update_score_labels():
    score_x_label.config(text=f"X: {score_x}")
    score_o_label.config(text=f"O: {score_o}")

# Create the buttons for the field
buttons = []
for i in range(9):
    button = Button(root, text="", font=("Arial", 20), width=3, height=1, command=partial(button_click, i))
    button.grid(row=i // 3, column=i % 3)
    buttons.append(button)

# Create a reset button
reset_button = Button(root, text="Reset", font=("Arial", 12), command=reset_game)
reset_button.grid(row=3, column=0, columnspan=3)

# Create score labels
score_x_label = Label(root, text="X: 0", font=("Arial", 12))
score_x_label.grid(row=0, column=3)
score_o_label = Label(root, text="O: 0", font=("Arial", 12))
score_o_label.grid(row=1, column=3)

root.mainloop()