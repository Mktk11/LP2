#include <stdio.h>

typedef struct{
	int x,y;
	int w,h;
}Triangle;

void print(Triangle* t){
	printf("Tam (%d,%d) / Pos (%d,%d)\n",t->w,t->h,t->x,t->y);
}
void main(void){
	Triangle t1 = {1,1,10,10};
	printf(&t1);
	return 0;
}
