export function LogM(msg,Desde?:string){
    let ver=true;
    if (ver){
        if (Desde) console.log(msg+" Desde:"+Desde);
        else console.log(msg);
    }
}