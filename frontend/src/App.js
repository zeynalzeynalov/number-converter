import React, {useEffect, useState} from 'react';

const App = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    let [number, setNumber] = useState('');
    let [selectedType, setSelectedType] = useState('');
    const [result, setResult] = useState(null);

    useEffect(() => {
        fetch('http://localhost:8080/api/number-converter/types')
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((json) => {
                if (json.status === 'success') {
                    setData(json.data);
                } else {
                    throw new Error('Data fetch was not successful');
                }
                setLoading(false);
            })
            .catch((error) => {
                setError(error);
                setLoading(false);
            });
    }, []);

    const handleSubmit = (event) => {
        event.preventDefault();

        const payload = {
            input: number,
            type: selectedType,
        };

        console.log(JSON.stringify(payload));

        fetch('http://localhost:8080/api/number-converter/convert', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload),
        })
            .then((response) => {
                if (!response.ok) {
                    //throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((json) => {

                console.log(json);

                setResult(json.data);

            })
            .catch((error) => {
                setError(error);
            });
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error.message}</div>;
    }

    return (
        <div style={{
            padding: "3em",
            overflowX: "auto",
            width: "100%",
            background: "#ef394e",
            boxSizing: "border-box" // <--- this line
        }}>
            <h1>Number Converter</h1>
            <br/>
            <form onSubmit={handleSubmit}>
                <label>
                    <h2>Select the converter type:</h2>
                    <select
                        value={selectedType}
                        onChange={(e) => setSelectedType(e.target.value)}
                        style={{
                            fontSize: 22,
                            width: 300
                        }}
                    >
                        <option value="" selected></option>
                        {data.map((item, index) => (
                            <option key={index} value={item}>
                                {item}
                            </option>
                        ))}
                    </select>
                </label>
                <br/>
                <label>
                    <h2>Enter Number:</h2>
                    <input
                        type="text"
                        value={number}
                        style={{
                            fontSize: 22,
                            width: 292
                        }}
                        onChange={(e) => setNumber(e.target.value)}
                    />
                </label>
                <br/>
                <br/>
                <button type="submit" style={{
                    fontSize: 22,
                    width: 300
                }}>Convert Number
                </button>
            </form>
            {result && (
                <div>
                    <h2>Conversion result:</h2>
                    <h3>{result}</h3>
                </div>
            )}
        </div>
    );
};

export default App;
