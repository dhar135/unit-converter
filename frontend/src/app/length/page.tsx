"use client"
import Form from 'next/form';
import { useState } from 'react';
import Link from 'next/link';
import { convertLength } from '../services/conversionService';
import { ConversionResponse } from '../services/conversionService';

export default function LengthPage() {
    // State to hold the result of the conversion
    const [result, setResult] = useState<ConversionResponse | null>(null);
    const [value, setValue] = useState<number | null>(null);
    const [fromUnit, setFromUnit] = useState<string>('');
    const [toUnit, setToUnit] = useState<string>('');

    async function handleSubmit(formData: FormData) {
        // FormData returns strings, so check accordingly
        if (value === null || fromUnit === '' || toUnit === '') {
            throw new Error('Missing input values');
        }

        // Convert the string value to a number
        const numericValue = Number(value);
        if (isNaN(numericValue)) {
            throw new Error('Value must be a valid number');
        }

        try {
            const result = await convertLength(numericValue, fromUnit, toUnit);
            console.log(`Conversion result: ${result.result} ${result.unitName}`);
            setResult(result);
        } catch (error) {
            console.error('Error converting length:', error);
        }
    }

    return (
        <div className="container mx-auto p-4">
            <div className="text-center mb-6">
                <h1 className='text-3xl'>Length Converter</h1>
                <p>Convert between meters, kilometers, miles, etc.</p>
            </div>

            <div className='flex flex-col items-center'>
                <Form action={handleSubmit} className="">
                    <div>
                        <label htmlFor="value">Value:</label>
                        <input
                            type="number"
                            value={value === null ? '' : value}
                            onChange={(e) => setValue(e.target.value ? Number(e.target.value) : null)}
                            className='border p-2 w-full bg-gray-100'
                            required
                        />
                    </div>
                    <div className='mt-4'>
                        <label htmlFor='fromUnit'>Convert From:</label>
                        <select
                            value={fromUnit}
                            onChange={(e) => setFromUnit(e.target.value)}
                            className='border p-2 w-full'
                            required
                        >
                            <option value="" disabled>Select unit</option>
                            <option value="km">Kilometer</option>
                            <option value="m">Meter</option>
                            <option value="cm">Centimeter</option>
                            <option value="mm">Millimeter</option>
                            <option value="mi">Mile</option>
                            <option value="ft">Foot</option>
                            <option value="in">Inch</option>
                            <option value="yd">Yard</option>
                        </select>
                    </div>
                    <div className='mt-4'>
                        <label htmlFor="toUnit">Convert To:</label>
                        <select
                            value={toUnit}
                            onChange={(e) => setToUnit(e.target.value)}
                            className='border p-2 w-full'
                            required
                        >
                            <option value="" disabled>Select unit</option>
                            <option value="km">Kilometer</option>
                            <option value="m">Meter</option>
                            <option value="cm">Centimeter</option>
                            <option value="mm">Millimeter</option>
                            <option value="mi">Mile</option>
                            <option value="ft">Foot</option>
                            <option value="in">Inch</option>
                            <option value="yd">Yard</option>
                        </select>
                    </div>
                    <div className='mt-4'>
                        <button type='submit' className='text-white bg-gray-600 hover:bg-black border font-medium rounded-sm p-2'>Submit</button>
                    </div>
                </Form>

                {result !== null && (
                    <div>
                        <h2 className='text-2xl'>Result:</h2>
                        <p>{String(result.result + " " + result.unitName)}</p>
                    </div>
                )}

                <div className='mt-6'>
                    <Link href="/" className='text-blue-500 hover:underline'>
                        <p>Back to Home</p>
                    </Link>
                </div>
            </div>
        </div>
    )
}