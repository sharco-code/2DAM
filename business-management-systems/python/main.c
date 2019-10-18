int printf(const char *format, ...);
int scanf(const char *format, ...);

int main( void ) {

    int x = 10;
    int *dx;
    dx = &x;
    printf("x:  %d\n",x);
    printf("&x: %x\n\n",&x);
    
    printf("dx:  %x\n", dx);
    printf("*dx: %d\n",*dx);

    *dx = 30;

    printf("x:  %d\n",x);

    return 0;
}