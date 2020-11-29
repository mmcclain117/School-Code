#include <stdio.h>
#include <stdlib.h>

#define ROWS 20
#define COLS 40

char buf[ROWS][COLS];
int maxr=ROWS;
int maxc=COLS;

void setup(){
int r,c; 
for(r=0;r<ROWS;r++)
 for(c=0;c<COLS;c++)
  buf[r][c]='_';
}

void print(){
int r,c;
for(r=0;r<ROWS;r++) {
 printf("%02d: ",r);
 for(c=0;c<COLS;c++)
  putchar((buf[r][c]=='_')?' ':buf[r][c]);
 putchar('\n');
}
}

void draw(x,h) int x,h; {
int r;
int c=x;
int i;
int j;
for(i=0,r=ROWS-h;r<ROWS;r++) {
 if(((c-i)>=0) && (buf[r][c-i]=='_')) buf[r][c-i]='/';
 if(((c+i+1)<COLS) && (buf[r][c+i+1]=='_')) buf[r][c+i+1]='\\';
 for(j=c-i;j<=c+i+1;j++)
  if((j>=0)&&(j<COLS)&&(buf[r][j]=='_')) buf[r][j]=' ';
 i++;
}
}

int main(){
 int x,h;
 setup(); 

 for(;;) {
 scanf("%d %d",&x,&h); while(getchar()!='\n');
 if((x==0)&&(h==0)) break;
 draw(x,h); 
 }
 print();
}
 
