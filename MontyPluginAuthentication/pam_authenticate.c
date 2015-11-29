#include <security/pam_appl.h>

extern int pam_authenticate(
	pam_handle_t *pamh,
	int flags
);
