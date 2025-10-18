package net.charalofromage.blocopolismod.util;

import net.minecraft.server.world.ServerWorld;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe utilitaire pour exécuter du code après un certain nombre de ticks.
 * Exemple :
 * TickScheduler.runLater(serverWorld, 20, () -> System.out.println("1 seconde plus tard !"));
 */
public class TickScheduler {
    private static final List<ScheduledTask> TASKS = new ArrayList<>();

    public static void tick(ServerWorld world) {
        Iterator<ScheduledTask> iterator = TASKS.iterator();
        while (iterator.hasNext()) {
            ScheduledTask task = iterator.next();
            if (task.world == world) {
                task.ticksLeft--;
                if (task.ticksLeft <= 0) {
                    task.action.run();
                    iterator.remove();
                }
            }
        }
    }

    public static void runLater(ServerWorld world, int ticks, Runnable action) {
        TASKS.add(new ScheduledTask(world, ticks, action));
    }

    // ✅ Classe interne classique (plus de "record")
    private static class ScheduledTask {
        final ServerWorld world;
        int ticksLeft;
        final Runnable action;

        ScheduledTask(ServerWorld world, int ticksLeft, Runnable action) {
            this.world = world;
            this.ticksLeft = ticksLeft;
            this.action = action;
        }
    }
}
