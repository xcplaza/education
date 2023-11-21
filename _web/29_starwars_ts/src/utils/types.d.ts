export interface Context {
    changeHero: (hero: string) => void
    hero: string
}

export interface Item {
    title: string,
    route: string
}

export interface Hero {
    name: string,
    img: string,
    url: string
}

export interface Friends {
    [key: string]: Hero
}

export interface HeroInfo {
    "birth_year": string,
    "eye_color": string,
    "gender": string,
    "hair_color": string,
    "height": string,
    "mass": string,
    "name": string,
    "skin_color": string
}

export interface DataStore {
    payload: any,
    time: number
}

export interface DataPlanet {
    "climate": string,
    "created": string,
    "diameter": string,
    "edited": string,
    "gravity": string,
    "id": number,
    "name": string,
    "orbital_period": string,
    "population": string,
    "rotation_period": string,
    "surface_water": string,
    "terrain": string
}

export interface FarGalaxyData {
    isLoading: boolean,
    filmTitle: string | null,
    filmData: string | null
}
