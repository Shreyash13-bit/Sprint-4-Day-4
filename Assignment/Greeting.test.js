import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import Greeting from "./Greeting";

describe("Greeting Component", () => {
  it("renders the greeting message", () => {
    render(<Greeting name="Shreyash" onGreet={() => {}} />);
    expect(screen.getByText("Hello, Shreyash")).toBeInTheDocument();
  });

  it("calls onGreet when button is clicked", () => {
    const greetMock = jest.fn();
    render(<Greeting name="Shreyash" onGreet={greetMock} />);

    fireEvent.click(screen.getByText("Greet"));
    expect(greetMock).toHaveBeenCalledWith("Shreyash");
  });
});
