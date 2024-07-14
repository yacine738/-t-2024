import random
from tkinter import *
from tkinter import simpledialog, messagebox
from PIL import Image, ImageTk

# Create the main window
root = Tk()
root.title("Hangman Game")
root.geometry("800x600")

# Load the hangman images
hangman_images = []
for i in range(1, 8):
    image = Image.open(f"images/hangman0{i}.png")
    hangman_images.append(ImageTk.PhotoImage(image))

# Create a label to display the hangman image
image_label = Label(root)
image_label.place(x=0, y=0)

# List of categories and their corresponding words
categories = {
    "Animals": ["cat", "dog", "bird", "fish", "elephant"],
    "Cities": ["new york", "los angeles", "chicago", "miami", "san francisco"],
    "Food": ["pizza", "sushi", "tacos", "steak", "salad"],
    "Movies": ["star wars", "the lord of the rings", "the matrix", "the dark knight", "the silence of the lambs"]
}

# Function to start a new game
def start_game(category):
    word = random.choice(categories[category]).lower()
    wrong_guesses = 0
    guessed_letters = set()
    MAX_TRIES = 6

    def guess_letter():
        nonlocal wrong_guesses
        letter = simpledialog.askstring("Guess a Letter", "Enter a letter:", parent=root)

        if not letter or not letter.isalpha() or len(letter) != 1:
            messagebox.showerror("Invalid Input", "Please enter a single letter.", parent=root)
            return

        letter = letter.lower()

        if letter in guessed_letters:
            messagebox.showinfo("Already Guessed", f"You've already guessed '{letter}'.", parent=root)
            return

        guessed_letters.add(letter)

        if letter not in word:
            wrong_guesses += 1
            image_label.config(image=hangman_images[wrong_guesses])

            if wrong_guesses == MAX_TRIES:
                messagebox.showinfo("Game Over", f"You lose! The word was '{word}'.", parent=root)
                return

            messagebox.showinfo("Wrong Guess", "Oops! That letter is not in the word.", parent=root)

        masked_word = ''.join(c if c in guessed_letters else '_' for c in word)
        if masked_word == word:
            messagebox.showinfo("You Win!", f"Congratulations! You guessed the word '{word}'.", parent=root)
            return

        messagebox.showinfo("Word Progress", f"Word: {masked_word}", parent=root)
        guess_letter()

    guess_letter()

# Create a dropdown menu to select the category
category_label = Label(root, text="Select a Category:")
category_label.pack()

category_var = StringVar(root)
category_var.set("Animals")  # Set the default category

category_menu = OptionMenu(root, category_var, *categories.keys())
category_menu.pack()

# Create a button to start the game
start_button = Button(root, text="Start Game", command=lambda: start_game(category_var.get()))
start_button.pack()

root.mainloop()