from tkinter import *
from tkinter import simpledialog,messagebox

main=Tk()
main.withdraw()

questions = ["What is the capital of Germany?", "Who is the President of the United States?", "What is the capital of France?", "What is the capital of Spain?"]
answers = ["Berlin", "Joe Biden", "Paris", "Madrid"]

score = 0

for i in range(len(questions)):
    print(questions[i])

    user_answer =simpledialog.askstring(questions[i],"Answer : ")

    if user_answer.lower() == answers[i].lower():
        print("Correct!")
        messagebox.showinfo("correct","correct")
        score += 1
    else:
        messagebox.showinfo("Wrong","Wrong")

messagebox.showinfo("score",str(score))