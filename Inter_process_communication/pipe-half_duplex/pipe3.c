#include<stdio.h>        //basic io
#include<unistd.h>      //fork function
#include<sys/types.h>  //pid_t,size_t data types
#include<string.h>    //for using strlen function

//IMPELMENTING 2WAY COMMUNICATION USING 2 PIPES

void main(){
int fd[2],fd1[2],childpid;
char string[20];
char rec[20];
pipe(fd);
pipe(fd1);
if((childpid=fork())==-1){
printf("ERROR COULD NOT FORK\n");
}
if(childpid==0){
//inside child process
close(fd[0]);
printf("%dchild  :ENTER A STRING :",getpid());
scanf("%s",string);
write(fd[1],string,strlen(string)+1);
close(fd1[1]);
read(fd1[0],rec,20);
printf("%dchild :RECIVED STRING :%s\n",getpid(),rec);

}
else{
close(fd[1]);
read(fd[0],rec,20);
printf("%dparent :RECIVED STRING :%s\n",getpid(),rec);
close(fd1[0]);
printf("%dparent :ENTER A STRING :",getpid());
scanf("%s",string);
write(fd1[1],string,strlen(string)+1);
}
}
