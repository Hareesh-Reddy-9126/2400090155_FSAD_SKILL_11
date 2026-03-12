import React, { useEffect, useState } from 'react';
import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8085';

function StudentManager() {
  const [students, setStudents] = useState([]);
  const [name, setName] = useState('');

  useEffect(() => {
    axios.get(`${API_URL}/students`).then(res => setStudents(res.data));
  }, []);

  const addStudent = () => {
    axios.post(`${API_URL}/students`, { name }).then(() => {
      axios.get(`${API_URL}/students`).then(res => setStudents(res.data));
      setName('');
    });
  };

  return (
    <div>
      <input value={name} onChange={e => setName(e.target.value)} placeholder="Student Name" />
      <button onClick={addStudent}>Add Student</button>
      <ul>
        {students.map(s => (
          <li key={s.id}>{s.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default StudentManager;
