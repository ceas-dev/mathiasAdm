async function verifyToken(token){
    const response = await fetch(`/auth/token/${token}`);
    if(!response.ok){
        throw new Error(response.status);
    }
    return await response.json();
}


export {verifyToken};