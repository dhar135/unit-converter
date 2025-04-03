export type ConversionResponse = {
    result: number;
    unitName: string;
}

export async function convertLength(value: number, fromUnit: string, toUnit: string): Promise<ConversionResponse> {
    const reponse = await fetch(
        `http://localhost:8080/api/convert/length?value=${value}&from=${fromUnit}&to=${toUnit}`
    );

    if (!reponse.ok) {
        throw new Error("Failed to fetch conversion data");
    }
    const data = await reponse.json();
    console.log(data);
    return data;
}

export async function convertWeight(value: number, fromUnit: string, toUnit: string): Promise<ConversionResponse> {
    const reponse = await fetch(
        `http://localhost:8080/api/convert/weight?value=${value}&from=${fromUnit}&to=${toUnit}`
    );

    if (!reponse.ok) {
        throw new Error("Failed to fetch conversion data");
    }
    const data = await reponse.json();
    return data;
}

export async function convertTemperature(value: number, fromUnit: string, toUnit: string): Promise<ConversionResponse> {
    const reponse = await fetch(
        `http://localhost:8080/api/convert/temperature?value=${value}&from=${fromUnit}&to=${toUnit}`
    );

    if (!reponse.ok) {
        throw new Error("Failed to fetch conversion data");
    }
    const data = await reponse.json();
    return data;
}