import type { Metadata } from 'next'
 
// These styles apply to every route in the application
import './globals.css'
 
export const metadata: Metadata = {
  title: 'Unit Converter',
  description: 'A simple unit converter application built with Next.js and Tailwind CSS',
}
 
export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <body>
        <div className="container mx-auto p-4">
          <div className="card bg-white shadow-md rounded-lg p-6">
            {children}
          </div>
        </div>
      </body>
    </html>
  )
}