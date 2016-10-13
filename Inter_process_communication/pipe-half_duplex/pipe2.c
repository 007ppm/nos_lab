#include<stdio.h>        //basic io
#include<unistd.h>      //fork function
#include<sys/types.h>  //pid_t,size_t data types
#include<string.h>    //for using strlen function

void main(){
int fd[2],childpid;
char string[20];
char rec[20];
pipe(fd);
if((childpid=fork())==-1){
printf("ERROR COULD NOT FORK\n");
}
if(childpid==0){
//inside child process
close(fd[0]);
printf("ENTER A STRING :");
scanf("%s",string);
//fgets(string,20,stdin);
write(fd[1],string,strlen(string)+1);
}
else{
close(fd[1]);
read(fd[0],rec,20);
printf("RECIVED STRING :%s\n",rec);
}
}
