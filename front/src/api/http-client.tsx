export namespace HttpClient {
  const BACKEND_URL = process.env.REACT_APP_BACKEND_URL || 'http://localhost:8080'

  export const get = async (path: string) => fetch(`${ BACKEND_URL }/${ path }`)
}
