import React  from "react";

export const Navbar = () => {
    return (
        <div className="bg-slate-600 h-16 px-16 items-center flex"> 
        <h1 className="text-4xl font-bold text-yellow-500 underline">  EM project</h1>
        <div className="space-x-4 ml-auto">
        <a className ="hover:text-blue-400 text-white" href="/"> HOME</a>
        <a className ="hover:text-blue-400 text-white" href="/"> PROFILE</a>
        <a className ="hover:text-blue-400 text-white" href="/"> LOGOUT</a>
        </div>
        </div>
    )
}
export default Navbar;