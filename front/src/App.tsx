import React, { useEffect, useState } from 'react';
import './App.css';
import { getAllGames } from './api/game.api'
import { Game } from './domain/game'

function App () {
  const [games, setGames] = useState<Game[] | undefined>(undefined)

  useEffect(() => {
    if (!games) {
      getAllGames().then(games => {
        setGames(games)
      })
    }
  });

  return (
    <div className="App">
      <header className="App-header">
        <h1>
          Liste des parties
        </h1>
        { games?.map(game => (
          <p key={ game.id }>
            { game.name }
          </p>
        )) }
      </header>
    </div>
  );
}

export default App;
