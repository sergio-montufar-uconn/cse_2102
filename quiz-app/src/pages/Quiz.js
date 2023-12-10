import React, { useState } from 'react';
import quizPageStyle from "../quizPageStyle";
import my_state from '../data/MyState';

const myQuestions = [
    {
        question: "What is 5 times 5?",
        answers: [ 
            { id: 0, answer: "10", isCorrect: false },
            { id: 1, answer: "55", isCorrect: false }, 
            { id: 2, answer: "25", isCorrect: true }, 
            { id: 3, answer: "0", isCorrect: false }
        ]
    },
    {
        question: "What class is CSE 2102?",
        answers: [ 
            { id: 0, answer: "Systems Programming", isCorrect: false }, 
            { id: 1, answer: "Intro to Software Engineering", isCorrect: true }, 
            { id: 2, answer: "Data Structures", isCorrect: false }, 
            { id: 3, answer: "Cybersecurity Lab", isCorrect: false } 
        ]
    },
    {
        question: "Who is the professor of CSE 2102?",
        answers: [ 
            { id: 0, answer: "Phillip Bradford", isCorrect: true }, 
            { id: 1, answer: "Hasan Baig", isCorrect: false }, 
            { id: 2, answer: "Kriti Bhargava", isCorrect: false }, 
            { id: 3, answer: "Ellie Sherafat", isCorrect: false } 
        ]
    },
    {
        question: "How do you print something out in JavaScript?",
        answers: [ 
            { id: 0, answer: "print()", isCorrect: false }, 
            { id: 1, answer: "console.log();", isCorrect: true }, 
            { id: 2, answer: "printf();", isCorrect: true },
            { id: 3, answer: "System.out.println()", isCorrect: false } 
        ]
    },
    {
        question: "What is the capital of Sao Tomé and Principe",
        answers: [ 
            { id: 0, answer: "It has none", isCorrect: false }, 
            { id: 1, answer: "Principe", isCorrect: false }, 
            { id: 2, answer: "Santo Antonio", isCorrect: false }, 
            { id: 3, answer: "São Tomé", isCorrect: true } 
        ]
    },
    {
        question: "What was the average for the first 2102 quiz?",
        answers: [ 
            { id: 0, answer: "5%", isCorrect: false }, 
            { id: 1, answer: "30%", isCorrect: false }, 
            { id: 2, answer: "47%", isCorrect: true }, 
            { id: 3, answer: "55%", isCorrect: false } 
        ]
    },
    {
        question: "What da heck are sockets?",
        answers: [ 
            { id: 0, answer: "They are generalized interprocess communication channels.", isCorrect: false }, 
            { id: 1, answer: "Man, I don't even know", isCorrect: true }, 
            { id: 2, answer: "They do something", isCorrect: false }, 
            { id: 3, answer: "Bingus", isCorrect: false } 
        ]
    },
    {
        question: "What kind of pants did Bradford wear during the 7th lecture of the semester?",
        answers: [ 
            { id: 0, answer: "Pants", isCorrect: true }, 
            { id: 1, answer: "Pants", isCorrect: false }, 
            { id: 2, answer: "Pants", isCorrect: false }, 
            { id: 3, answer: "Pants", isCorrect: false } 
        ]
    },
    {
        question: "Is water wet?",
        answers: [ 
            { id: 0, answer: "No, you're an idiot", isCorrect: false }, 
            { id: 1, answer: "What the heck is this question?", isCorrect: false }, 
            { id: 2, answer: "Water doesn't exist", isCorrect: false }, 
            { id: 3, answer: "Well duh of course it is", isCorrect: true } 
        ]
    },
    {
        question: "Bingus > Asian Boy? (Skribblio)",
        answers: [ 
            { id: 0, answer: "Forever and always", isCorrect: true }, 
            { id: 1, answer: "Asian Boy Better", isCorrect: false }, 
            { id: 2, answer: "Bingus good Bingus great", isCorrect: true }, 
            { id: 3, answer: "Bingus rules", isCorrect: true } 
        ]
    }
]
const Quiz = () => {
    const [score, setScore] = useState(0);
    const [count, setCount] = useState(0);
    const [isFinished, setIsFinished] = useState(false);
    const [question, setQuestion] = useState(0);

    const incrementScore = (isCorrect) => {
        if (isCorrect) {
            setScore(score + 1);
        }
        
        if (question + 1 < myQuestions.length) {
            setQuestion(question + 1);
        } else {
            setIsFinished(true);
        }

        setCount(count + 1);
    };

    const handleSubmit = () => {
        my_state.my_score = score;
        my_state.my_count = count;

        alert(`Total score: ${score}/${count}`);
    };

    return (
        <div style={quizPageStyle}>
            <h2>
            Question: {question + 1} out of {myQuestions.length}
            </h2>
            <h3 className="qtext">{myQuestions[question].question}</h3>
            <ul>
            {myQuestions[question].answers.map((answer) => {
              return (
                <li
                  key={answer.id}
                  onClick={() => incrementScore(answer.isCorrect)}>
                  {answer.answer}
                </li>
              );
            })}
            </ul>
            <br />
            {isFinished ? (
                <button onClick={handleSubmit}>Finish Quiz</button>
            ) : (<></>)}
        </div>
    );
}

export default Quiz;