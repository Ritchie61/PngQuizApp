import React from 'react';
import { render, fireEvent } from '@testing-library/react-native';
import App from './App';

describe('QuizApp', () => {
  it('renders the first question', () => {
    const { getByText } = render(<App />);
    
    // Check that the first question is rendered
    expect(getByText('What is the capital of France?')).toBeTruthy();
  });

  it('shows correct feedback for the correct answer', () => {
    const { getByText } = render(<App />);
    
    // Simulate pressing the correct answer button
    fireEvent.press(getByText('Paris'));
    
    // Check that the correct feedback alert is shown
    expect(getByText('Correct!')).toBeTruthy();
  });

  it('shows incorrect feedback for the incorrect answer', () => {
    const { getByText } = render(<App />);
    
    // Simulate pressing an incorrect answer button
    fireEvent.press(getByText('Berlin'));
    
    // Check that the incorrect feedback alert is shown
    expect(getByText('Incorrect')).toBeTruthy();
  });

  it('navigates to the next question after answering', () => {
    const { getByText } = render(<App />);
    
    // Answer the first question correctly
    fireEvent.press(getByText('Paris'));
    
    // Check that the second question is rendered
    expect(getByText('What is 2 + 2?')).toBeTruthy();
  });
});
