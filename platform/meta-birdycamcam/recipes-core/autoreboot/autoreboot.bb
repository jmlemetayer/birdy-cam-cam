SUMMARY = "Reboot the board every day"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://autoreboot.service \
    file://autoreboot.timer \
"

inherit systemd

SYSTEMD_SERVICE:${PN} = " \
    autoreboot.timer \
"

do_install:append() {
    install -Dm644 ${WORKDIR}/autoreboot.service ${D}${systemd_system_unitdir}/autoreboot.service
    install -Dm644 ${WORKDIR}/autoreboot.timer ${D}${systemd_system_unitdir}/autoreboot.timer
}

FILES:${PN} = "${systemd_system_unitdir}"
