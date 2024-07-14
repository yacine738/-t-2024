import random


categories = ["animals", "cities", "food", "movies"]


words = {
    "animals": ["cat", "dog", "bird", "fish", "elephant"],
    "cities": ["new york", "los angeles", "chicago", "miami", "san francisco"],
    "food": ["pizza", "sushi", "tacos", "steak", "salad"],
    "movies": ["star wars", "the lord of the rings", "the matrix", "the dark knight", "the silence of the lambs"]
}


category = random.choice(list(words.keys()))
word = random.choice(words[category])


word = word.lower()


no_guess = 0


MAX_TRIES = 10

while True:

    key = input("Guess a letter: ")


    if key in word:
        print(f"{word} contains {key}")
        word = word.replace(key, "")
        print(len(word))

        if len(word) == 0:
            print("You win!")
            break
    else:
        print("Wrong!")
        no_guess += 1

        if no_guess >= MAX_TRIES:
            print(f"You lose. The word was {category} - {word}.")
            break
