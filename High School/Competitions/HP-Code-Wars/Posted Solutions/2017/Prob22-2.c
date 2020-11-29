#include <stdio.h>
#include <stdlib.h>

#define BUF 1024
#define ITERS 9

char d[ITERS][BUF] = { "7", 0 , 0, 0, 0, 0, 0, 0, 0 };

char xform(c,n) char c; int n; { char r; r=c+n; if(r>'8') r-=8; if(r<'1') r+=8; return(r); }

void plot(n) int n; {
int dx[8]={0,1,1,1,0,-1,-1,-1};
int dy[8]={1,1,0,-1,-1,-1,0,1};

int minx, miny, maxx, maxy;

char buf[BUF][BUF];
int x=BUF/2;
int y=BUF/2;
int i,j;

minx=miny=maxx=maxy=BUF/2;

for(i=0;i<BUF;i++) 
 for(j=0;j<BUF;j++)
  buf[i][j]=' ';

buf[x][y]='@';

for(i=0;d[n][i];i++) 
for(j=0;j<2;j++)
{
 x+=3*dx[(d[n][i]-'0')%8];
 y+=dy[(d[n][i]-'0')%8];
 buf[x][y]=(buf[x][y]==' ')?'#':'*';

 if(x>maxx) maxx=x;
 if(y>maxy) maxy=y;
 if(x<minx) minx=x;
 if(y<miny) miny=y;

 if((x<0)||(x==BUF)||(y<0)||(y==BUF)) printf("OVERFLOW\n");
}

printf("Plotting (%d,%d)-(%d,%d)\n",minx,miny,maxx,maxy);

for(j=maxy;j>=miny;j--) {
 for(i=minx;i<=maxx;i++)
  putchar(buf[i][j]);
 putchar('\n');
}
printf("done with %d\n",n);
}

int main(){
int i,j;
int f=0;
char start;
int n;

scanf("%c %d",&start,&n);
printf("Staring in direction %c and iterating %d times\n",start,n);
d[0][0]=start;
for(i=0;i<ITERS;i++) {
 for(f=1,j=0;d[i][j];j++) {
  d[i+1][j*2]=xform(d[i][j],f?1:-1);
  d[i+1][j*2+1]=xform(d[i][j],f?-1:1);
  f=!f;
 }
 d[i+1][j*2]=0;
/* printf("%s\n",d[i+1]); */
 }
 plot(n);
}
