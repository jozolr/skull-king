import { HttpClient } from './http-client'
import { Game } from '../domain/game'


export async function getAllGames (): Promise<Game[]> {
  const games = await HttpClient.get('games')
  return games.json()
}
