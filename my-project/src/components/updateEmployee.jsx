import React from 'react'
import { AiFillCheckSquare } from 'react-icons/ai';
import { useNavigate } from 'react-router-dom';
import EmployeeService from './EmployeeService';
import { useParams } from 'react-router-dom';
import { useEffect } from 'react';

const updateEmployee = () => {

    const{id} = useParams();
    const navigate = useNavigate();
    const [employee, setEmployee] = React.useState({
    id: id,     
    name: "",
    phone: "",
    email: "",
  });
   const handleChange = (e) => {
    const  value  = e.target.value;
    setEmployee({...employee, [e.target.name]: value })
   }

   
      useEffect(() => {
         const fetchdata = async () => {
          try {
           const response = await EmployeeService.getEmployeeById(employee.id);
           setEmployee(response.data);
          }
          catch (error) {
           console.log(error);
         }
       }
       fetchdata();
       
       }, []);

   const updateEmployee = (e) => {
    e.preventDefault();
    EmployeeService.updateEmployee(employee,id)
    .then((response) => {
        console.log(" saved", response);
        navigate("/");
    })
    .catch((error) => {
        console.log(error);
    })

   }

 
  return (
    <div className="max-w-xl mx-40 bg-slate-800 my-20 rounded shadow py-4 px-8">
    <div className='text-4xl tracking-wider font-bold text-center py-4 px-8 text-white uppercase '>
      <p className='flex item-center gap-2' ><AiFillCheckSquare/>Update Employee </p>
    </div>

    <div className='tmx-10 my-2'>
      <input type='text'
      name="name"
      value={employee.name}
      onChange={(e)=> handleChange(e)}
       className=" w-full py-2 my-4 bg-slate-200 " placeholder="Name"></input>

      <input type='number'
      name ='phone'
       value={employee.phone}
      onChange={(e)=> handleChange(e)}
       className=" w-full py-2 my-4 bg-slate-200" placeholder="Phone"></input>

      <input type='email'
        name='email'
        value={employee.email}
        onChange={(e)=> handleChange(e)}
       className=" w-full py-2 my-4 bg-slate-200 " placeholder="Email"></input>
    </div>

    <div className='flex my-4 space-x-4 px-30'>
      <button 
      onClick={updateEmployee}
      className='bg-green-300 hover:bg-green-800 py-2 px-4 rounded '>updateEmployee</button>


      <button 
       onClick = {()=> navigate("/")}
      className= 'bg-red-400 hover:bg-red-900 py-2 px-4 rounded '>Cancel</button>
    </div>
    </div>
  )
}

export default updateEmployee
