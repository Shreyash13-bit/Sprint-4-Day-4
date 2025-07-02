import React from "react";

export default function Greeting({ name, onGreet }) {
  const handleClick = () => {
    onGreet(name);
  };

  return (
    <div>
      <h1>Hello, {name}</h1>
      <button onClick={handleClick}>Greet</button>
    </div>
  );
}
