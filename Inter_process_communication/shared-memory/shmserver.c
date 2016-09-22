#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#define MAXSIZE     27
int main()
{
char c;
int shmid;
int key;
char *shm, s[100];
key = 20;//numeric key to be assigned to the returned shared memory segment
shmid = shmget(key, MAXSIZE, IPC_CREAT | 0666) ;
//returns shared memory segment identifier on success
shm = shmat(shmid, NULL, 0);
// RETURNS: address at which segment was attached to the process
printf("Enter string:");
scanf("%s",s);
strcpy(shm,s);
shmdt(shm);//destroy segment
return 0; 
}

