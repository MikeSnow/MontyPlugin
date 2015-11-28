#include <security/pam_appl.h>
#include <security/pam_misc.h>
#include <pwd.h>
#include <sys/types.h>
#include <stdio.h>
#define MY_CONFIG "su"
static struct pam_conv conv = {misc_conv,NULL};

main(){
	pam_hand_t* pamh;
	int result;
	struct passwd *pw;

	if((pw = getpwuid(getuid())) == NULL)
		perrror("getpwuid");
	else if((result=pam_start(MY_CONFIG, pw->pw_name, &conv, &pamh))!=PAM_SUCCESS)
		fprintf(stderr, "start Failed: %d\n", result);
	else if((result=pam_authenticate(pamh,0))!=PAM_SUCCESS)
		fprintf(stderr, "authenticate Failed: %d\n", result);
	else if((result=pam_acct_mgmt(pamh,0))!=PAM_SUCCESS)
		fprintf(stderr, "acct_mgmt Failed: %d\n", result);
	else if((result=pam_end(pamh,result))!=PAM_SUCCESS)
		fprintf(stderr, "end Failed: %d\n", result);
	else
		//ejecutar aplicación correspondiente.
		fprintf("Se ejecuta la aplicación");
}
