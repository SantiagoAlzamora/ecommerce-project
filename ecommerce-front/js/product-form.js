const inputProductName = document.getElementById("productName")
const inputProductPrice = document.getElementById("price")
const inputProductStock = document.getElementById("stock")
const inputProductImage = document.getElementById("image")
const button = document.getElementById("button")

button.addEventListener('click', async (event)=>{
    event.preventDefault()
    const imageURL = await getImageUrl(inputProductImage.files[0])
    const product = {
        name:inputProductName.value,
        price:inputProductPrice.value,
        stock:inputProductPrice.value,
        image:imageURL
    }

    console.log(product);

    const res = await fetch("http://localhost:8080/products",{
        body: JSON.stringify(product),
        headers:{
            "Content-Type":"application/json"
        },
        method: "POST",
    })

})


const getImageUrl = async (file) => {
    const data = new FormData();
    data.append("file", file);
    data.append("upload_preset", "santi-preset");
    data.append("cloud_name", "santicloud");


    const res = await fetch("https://api.cloudinary.com/v1_1/santicloud/image/upload",
        {
            method: "post",
            body: data,
        })
    const resultado = await res.json()
    return resultado.secure_url
}

