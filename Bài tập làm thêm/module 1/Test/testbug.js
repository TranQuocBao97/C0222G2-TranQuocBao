a=1;
b=1;
c=2;
f=0;
if(a==b && a==c)
{
    alert(-1);
}
else if (a>=b)
{
    f=a;
    console.log(f)
    a=b;
    console.log(a)
    b=f;
    console.log(b)
}
else if(b>c)
{
    f=b;
    console.log(f)
    b=c;
    console.log(b)
    c=f;
    console.log(c)
    alert(b);
    console.log(b)
}
else
{
    alert(b);
}