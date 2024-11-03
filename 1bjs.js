let sub = document.getElementById("add")
sub.addEventListener("click",()=>{
        let inp = document.getElementById('task');
        let task = inp.value
        if(task==""){
            alert("add a task");
            return;
        }
        let ul = document.getElementById("tasklist")
        let li = document.createElement("li")
        li.textContent=task
        let rmbtn = document.createElement("button")
        rmbtn.textContent="remove"
        li.appendChild(rmbtn)
        rmbtn.style.marginLeft="50px"
        rmbtn.addEventListener("click",()=>remove(li))
        li.appendChild(rmbtn)
        ul.append(li)
        li.addEventListener("click",()=>{
            li.classList.toggle("completed")
        })
})
function remove(li){
    li.remove()
}

