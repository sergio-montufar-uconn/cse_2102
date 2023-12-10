import React from 'react';
import { fireEvent, render, screen } from '@testing-library/react';
import App from "./App";
// import Quiz from "./pages/Quiz";


// test('renders learn react link', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/learn react/i);
//   expect(linkElement).toBeInTheDocument();
// });


test('Renders with correct color', () => {
  const { container } = render(<App />);
  const questionDiv = container.querySelector('#question-div');
  expect(questionDiv).toHaveStyle('background-color: grey');
});


test('Renders with correct header', () => {
  render(<App />);
  expect(screen.getByText("The Most Amazing Quiz")).toBeInTheDocument();
})

test('Second Question', () => {
  const { getByText } = render(<App />);
  fireEvent.click(getByText(/25/i));
  const nextQuestion = getByText(/What class is CSE 2102?/i);
  expect(nextQuestion).toBeInTheDocument();

});