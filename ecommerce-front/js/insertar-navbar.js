const body = document.getElementById("body")
const header = document.getElementById("header")

body.addEventListener('load',async ()=>{
    body.insertBefore(header)
})


