interface Area {
    width: number
    depth: number
}

interface Volume extends Area {
    height: number
}

function dimension(): Area
function dimension(x: number, y: number, z: number): Volume
function dimension(x: number, y: number): Area

function dimension(x?: number, y?: number, z?: number) {
    if (!x && !y && !z)
        return {width: null, depth: null}
    if (!z)
        return {width: x, depth: y}
    return {width: x, depth: y, height: z}
}

console.log(dimension())
console.log(dimension(10, 5))
console.log(dimension(10, 5, 2))