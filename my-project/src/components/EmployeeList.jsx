import React from "react";
import { PiAddressBookFill } from 'react-icons/pi';
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import EmployeeService from "./EmployeeService";


export const Navbar = () => {

    const [loading, setLoading] = useState(true);
    const [employees, setEmployees] = useState(null);

    useEffect(() => {
      const fetchdata = async () => {
        setLoading(true)
       try {
        const response = await EmployeeService.getEmployees();
        setEmployees(response.data);
       }
       catch (error) {
        console.log(error);
      }
      setLoading(false)
    }
    fetchdata();
    
    }, []);

    const deleteEmployee = (e, id) => {
      e.preventDefault();
      EmployeeService.deleteEmployee(id)
      .then(() =>{
        if(employees){
        setEmployees((prevElement) =>{
         return prevElement.filter((employee) => employee.id !== id);
        })
      }
      })
    };
    const editEmployee = (e, id) => {
      e.preventDefault();
      navigate(`/editEmployee/${id}`);
    };

    const navigate = useNavigate();
    return (
        <div className="container mx-auto my-8">
        <div>
          <button 
          onClick={() => navigate("/addEmployee")}
          className= "bg-slate-500 hover:bg-blue-400  my-12  font-bold px-20 py-2  rounded uppercase flex item-center gap-2 "> <PiAddressBookFill/>Add Employee</button>
        </div>

        <div>
          <table className="shadow">
            <thead className="bg-slate-600 text-white">
              <tr>
              <th className="px-6 py-3 uppercase tracking-wide">Name</th>
              <th className="px-6 py-3 uppercase tracking-wide">Phone</th>
              <th className="px-6 py-3 uppercase tracking-wide">Email</th>
              <th className="px-6 py-3 uppercase tracking-wide">Action</th>
              </tr>
            </thead>

            {!loading &&(
            <tbody>
              {employees.map(employee =>(
             <tr className="hover:bg-white hover:text-black">
              <td className="text-left px-6 py-4 whitespace-nowrap"> {employee.name}</td>
              <td className="text-left px-6 py-4 whitespace-nowrap"> {employee.phone}</td>
              <td className="text-left px-6 py-4 whitespace-nowrap"> {employee.email}</td>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                 <a onClick={(e,id) => editEmployee(e,employee.id)} className="hover:text-yellow-600 hover:cursor-pointer">Edit</a>
                  <a onClick={(e,id) => deleteEmployee(e,employee.id)} className="hover:text-red-500 hover:cursor-pointer"> Delete </a> 
                  </td>
             </tr>
              ))}
            </tbody>
            )}
          </table>
        </div>
 </div>

         )
  }  
 export default Navbar;