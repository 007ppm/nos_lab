#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE     27
int main()
{
int shmid;
key_t key;
char *shm, *s;
key = 20;
shmid = shmget(key, MAXSIZE, 0666);
shm = shmat(shmid, NULL, 0);
printf("%s\n",shm);
shmdt(shm);
}
