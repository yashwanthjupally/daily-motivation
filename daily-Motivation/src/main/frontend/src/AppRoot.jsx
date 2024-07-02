import { useEffect, useState } from "react";

function AppRoot() {
    const [data, setData] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        console.log("Fetching daily motivational quote...");
        fetch('/api/v1/motivationals/daily')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(json => {
                console.log("Fetched data:", json);
                setData(json.data);
                setIsLoading(false);
            })
            .catch(error => {
                console.error("Fetch error:", error);
                setIsLoading(false);
            });
    }, []);

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (!data) {
        return <div>No data available</div>;
    }

    return (
        <div className="container">
            <div className="row">
                <div className="col">
                    <h1 className="text-center display-1">Daily Motivational</h1>
                    <hr />
                </div>
            </div>
            <div className="row">
                <div className="col">
                    <ul key={data.id}>
                        <li><img className="img-fluid" src={data.image_path} alt="Motivational" /></li>
                        <li><p className="content-date">{data.publishedAt}</p></li>
                        <li>
                            <figure className="text-center">
                                <blockquote className="blockquote">
                                    <p className="display-4">"{data.quote}"</p>
                                </blockquote>
                                <figcaption className="blockquote-footer">
                                    <cite className="display-6" title={data.author}>{data.author}</cite>
                                </figcaption>
                            </figure>
                        </li>
                    </ul>
                    <hr />
                </div>
            </div>
        </div>
    );
}

export default AppRoot;
