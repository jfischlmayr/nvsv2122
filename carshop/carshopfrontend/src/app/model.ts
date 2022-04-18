export interface Car {
  make: Make
  model: string
  price: number
}

export interface Make {
  name: string
}

export interface User {
  name: string
}

export interface AuthenticationModel {
  userName: string
  password: string
}

export interface LoginResult {
  token: string
}
