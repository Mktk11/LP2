#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////
typedef struct {
    Figure super;
    int w,h;
    int xpoints[6];
    int ypoints[6];
} Hexagono;

void Hexagono_print (Hexagono* this) {
	int i;
    Figure* sup = (Figure*) this;
    printf(" Hexagono de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
    printf("Com os pontos: ");
    for (i=0; i<6; i++) {
    	printf("\n(%d, %d)", this->xpoints[i], this->ypoints[i]);
	}
	printf("\n");
}
Hexagono* hexagono_new (int x, int y, int w, int h) {
    Hexagono* this = malloc(sizeof(Hexagono));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Hexagono_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    
    this->xpoints[0] = (x + w/5);
	this->xpoints[1] = (x+w*4/5);
	this->xpoints[2] = x+w;
	this->xpoints[3] = (x+w*4/5);
	this->xpoints[4] = (x+w/5);
	this->xpoints[5] = x*(w/w);  
	
	this->ypoints[0] = y;
    this->ypoints[1] = y;
    this->ypoints[2] = y+(h/2);
    this->ypoints[3] = y+h;
    this->ypoints[4] = y+h;
    this->ypoints[5] = y+(h/2);  
}

///////////////////////////////////////////////////////////////////////////////
typedef struct {
    Figure super;
    int w, h;
    int xpoints[3];
    int ypoints[3];
} Triangle;

void Triangle_print (Triangle* this) {
	int i;
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d). ",
           this->w, this->h, sup->x, sup->y);
    printf("\nCom os pontos: ");
    for (i=0; i<3; i++) {
    	printf("\n(%d, %d)", this->xpoints[i], this->ypoints[i]);
	}
	printf("\n");
}

Triangle* triangle_new (int x, int y, int w, int h) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangle_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    
    this->xpoints[0] = x;
    this->xpoints[1] = (w/2) + x ;
    this->xpoints[2] = w + x;
        
    this->ypoints[0] = y;
    this->ypoints[1] = y - h;
    this->ypoints[2] = y;
    
}
///////////////////////////////////////////////////////////////////////////////

void main (void) {
	int i;
    Figure* figs[2] = {
        (Figure*) hexagono_new(60,10,20,20),
        (Figure*) triangle_new(150,200,120,120),
    };

    ///

    for ( i=0; i<2; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for ( i=0; i<2; i++) {
        free(figs[i]);
    }
}
