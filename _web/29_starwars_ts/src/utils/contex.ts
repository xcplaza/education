import React from "react";
import {Context} from "./types";
import {defaultHero} from "./constants";

export const SWContext = React.createContext<Context>({
    changeHero: (hero) => {},
    hero: defaultHero
});