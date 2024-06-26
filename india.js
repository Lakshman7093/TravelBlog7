function imgK(pic,heading,discription)
{
    document.getElementById("bigscreen").removeAttribute("style")
    document.getElementById("imgheading").innerHTML=heading;
    document.getElementById("imgparagraph").innerHTML=discription;
  
    bigscreen.style.display="flex"
    fullimg.src=pic;
}
function imgV()
{
    document.getElementById("bigscreen").setAttribute("style","display:none")
    // console.log("calling")
}