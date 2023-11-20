function pretty(arg: string | number): string | number {
    return typeof arg === 'string' ? arg.trim() : +arg.toFixed(2);
}

console.log(pretty('       hello'));
console.log(pretty(1234567.5487878));

class SuccessResponse {
    constructor(header: string[], body: string) {
        this.header = header
        this.body = body
    }

    header: string[];
    body: string;
}

class ErrorResponse {
    header: string[];
    code: number;

    constructor(header: string[], code: number) {
        this.header = header
        this.code = code
    }
}

function responseHandle(response: SuccessResponse | ErrorResponse): { message: string | number } {
    return response instanceof SuccessResponse ? {message: response.body} : {message: response.code};
}

console.log(responseHandle(new SuccessResponse(['auto'], 'hello')));
console.log(responseHandle(new ErrorResponse(['auto'], 404)));