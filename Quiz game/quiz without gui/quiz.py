questions = ["What is the capital of Germany?", "Who is the President of the United States?", "What is the capital of France?", "What is the capital of Spain?"]
answers = ["Berlin", "Joe Biden", "Paris", "Madrid"]

score = 0

for i in range(len(questions)):
    print(questions[i])

    user_answer = input("Answer: ")

    if user_answer.lower() == answers[i].lower():
        print("Correct!")
        score += 1
    else:
        print(f"Incorrect. The correct answer is {answers[i]}.")

print(f"Score: {score}/{len(questions)}")
