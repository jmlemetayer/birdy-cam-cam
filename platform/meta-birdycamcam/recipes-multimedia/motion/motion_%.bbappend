SRC_URI += " \
    file://motion.conf \
    file://motion.service \
"

inherit systemd

SYSTEMD_SERVICE:${PN} = "motion.service"

do_install:append() {
    install -Dm644 ${WORKDIR}/motion.conf ${D}${sysconfdir}/motion/motion.conf
    install -Dm644 ${WORKDIR}/motion.service ${D}${systemd_system_unitdir}/motion.service
}
