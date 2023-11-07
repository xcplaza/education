import React from 'react';

const MyComponent = () => {
    let title = 'old title';
    (function () {
        setTimeout(() => {
            title = 'new title';
            console.log('All done')
        }, 1000)
    })()
    return (
        <div>
            {title}
        </div>
    );
};

export default MyComponent;