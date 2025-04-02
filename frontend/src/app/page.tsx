import Link from "next/link";

export default function Home() {
  return (
    <div className="container mx-auto p-4">
      <div className="card bg-white shadow-md rounded-lg p-6">
        <div>
          <h1 className="text-3xl text-center font-bold text-black">Unit Converter</h1>
          <p className="mt-4 text-red-400 font-bold text-center">
            This is a simple unit converter application built with Next.js and Tailwind CSS.
          </p>
        </div>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4 mt-6">
          <Link href="/length" className="p-6 border rounded hover:bg-gray-50 text-center">
              <h2 className="text-xl font-semibold text-gray-600">Length Converter</h2>
              <p className="text-gray-600">Convert between meters, kilometers, miles, etc.</p>
          </Link>
          <Link href="/weight" className="p-6 border rounded hover:bg-gray-50 text-center">
              <h2 className="text-xl font-semibold text-gray-600">Weight Converter</h2>
              <p className="text-gray-600">Convert between grams, kilograms, pounds, etc.</p>
          </Link>
          <Link href="/temperature" className="p-6 border rounded hover:bg-gray-50 text-center">
              <h2 className="text-xl font-semibold text-gray-600">Length Converter</h2>
              <p className="text-gray-600">Convert between Fahrenheit, Celcius, and Kelvin</p>
          </Link>
        </div>
      </div>
    </div>
  );
}
