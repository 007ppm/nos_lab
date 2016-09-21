#include  <stdio.h>
#include  <sys/types.h>

void  ChildProcess();                /* child process prototype  */
void  ParentProcess();               /* parent process prototype */

void main()     {
        pid_t pid;                  /*data type for process id , may use int instead*/
        pid = fork();
        wait();                     /* make the calling process wait till its child end , if wait not used child and parent execute in parallel */
        if (pid == 0)
                ChildProcess();
        else if (pid>0)
                ParentProcess();
        else
                printf("AN error occured :couldnt create child");
}

void  ChildProcess(){

     printf("   Im the child Procces my parent is  %d\n",getppid());
     printf("   My pid  is %d\n",getpid());
     printf("   *** Child process is done ***\n\n\n\n");
}

void  ParentProcess(){
     printf("Im the parent process  \n");
     printf("   My process id is  %d\n",getpid());
     printf("   *** parent process is done ***\n\n\n\n");
}
